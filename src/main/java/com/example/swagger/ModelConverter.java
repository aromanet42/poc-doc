/**
 * Copyright (C) 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 */
package com.example.swagger;

import com.fasterxml.jackson.databind.JavaType;
import com.github.kongchen.swagger.docgen.reader.ModelModifier;
import io.swagger.converter.ModelConverterContext;
import io.swagger.models.Model;
import io.swagger.models.properties.Property;
import io.swagger.util.Json;

import java.lang.reflect.Field;
import java.util.Iterator;

public class ModelConverter extends ModelModifier {

    public static final String DEPRECATED_KEY = "x-deprecated";

    public ModelConverter() {
        super(Json.mapper());
    }

    @Override
    public Model resolve(JavaType type, ModelConverterContext context, Iterator<io.swagger.converter.ModelConverter> chain) {
        Model model = super.resolve(type, context, chain);

        Class<?> cls = type.getRawClass();

        if (model != null && model.getProperties() != null) {
            for (String modelPropKey : model.getProperties().keySet()) {
                Property property = model.getProperties().get(modelPropKey);

                try {
                    enhanceProperty(property, cls.getDeclaredField(property.getName()));

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                    return model;
                }
            }
        }

        return model;
    }

    private void enhanceProperty(Property swaggerProperty, Field javaField) throws NoSuchFieldException {

        Deprecated declaredAnnotation = javaField.getDeclaredAnnotation(Deprecated.class);
        if (declaredAnnotation != null) {
            swaggerProperty.getVendorExtensions().put(DEPRECATED_KEY, 1);
        }
    }
}
