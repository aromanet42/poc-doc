package com.example.swagger;

import com.example.ApiLogging;
import com.github.kongchen.swagger.docgen.LogAdapter;
import com.github.kongchen.swagger.docgen.reader.SpringMvcApiReader;
import io.swagger.models.Operation;
import io.swagger.models.Swagger;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class SwaggerApiReader extends SpringMvcApiReader {
    public SwaggerApiReader(Swagger swagger, LogAdapter LOG) {
        super(swagger, LOG);
        this.setTypesToSkip(new ArrayList<>());

        System.out.println("Instanciating Custom SwaggerApiReader");
    }

    @Override
    protected void readImplicitParameters(Method method, Operation operation) {
        super.readImplicitParameters(method, operation);

        // read other annotation from Method
        if (operation != null) {
            ApiLogging apiLogging = method.getDeclaredAnnotation(ApiLogging.class);
            if (apiLogging != null) {
                operation.getVendorExtensions().put("x-api-code", apiLogging.code());
            }
        }
    }
}
