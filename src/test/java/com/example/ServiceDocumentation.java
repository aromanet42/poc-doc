package com.example;


import com.example.bean.OrderBean;
import com.example.bean.OrderPaymentInfoBean;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.snippet.Snippet;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NewDocApplication.class)
@WebAppConfiguration
public class ServiceDocumentation {

    @Rule
    public final RestDocumentation restDocumentation = new RestDocumentation("target/generated-snippets");

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    private RestDocumentationResultHandler document;

    @Before
    public void setUp() {
        this.document = document("{method-name}-{step}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint()));
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .alwaysDo(this.document)
                .build();
    }

    @Test
    public void listPeople() throws Exception {
        this.document.snippets(responseDocSnipper(true, rootService(), getServiceDocFields()));

        this.mockMvc.perform(get("/service").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void listPeopleXml() throws Exception {
        this.document.snippets(responseDocSnipper(false, rootService(), getServiceDocFields()));

        this.mockMvc.perform(get("/service").accept(MediaType.APPLICATION_XML))
                .andExpect(status().isOk());
    }

    @Test
    public void post_service_request_parameters() throws Exception {
        this.mockMvc.perform(post("/service")
                .param("code", "NEW_SERVICE_CODE")
                .param("name", "this is the new service name")
        )
                .andDo(document("{method-name}-{step}", requestParameters(
                        parameterWithName("code").description("service code"),
                        parameterWithName("name").description("service name")
                )))
                .andExpect(status().isOk());
    }

    @Test
    public void post_service_request_body() throws Exception {
        this.mockMvc.perform(post("/service").content("{\"code\": \"NEW_CODE\", \"name\":\"this is the new service name\"}"))
                .andDo(document("{method-name}-{step}", requestDocSnipper(true, rootService(), getServiceDocFields())))
                .andExpect(status().isOk());
    }

    @Test
    public void orderBean_json() throws Exception {
        DocField orderBeanRoot = new DocField("orderBean", OrderBean.class, "", true);
        DocField[] fields = getDocFieldsForOrderBean();

        this.mockMvc.perform(get("/service/orderBean").accept(MediaType.APPLICATION_XML))
                .andExpect(status().isOk());

        this.document.snippets(responseDocSnipper(true, orderBeanRoot, fields));
        this.mockMvc.perform(get("/service/orderBean").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private DocField[] getDocFieldsForOrderBean() {
        return new DocField[]{
                new DocField("channelCode", String.class, "channel code"),
                new DocField("offers", List.class, "liste des offres"),

                new DocField("paymentInfo", OrderPaymentInfoBean.class, "infos de paiement"),
                new DocField("paymentInfo.imprintNumber", String.class, "numero")
        };
    }

    private DocField rootService() {
        return new DocField("service", Service.class, "", true);
    }

    private DocField[] getServiceDocFields() {
        return new DocField[]{
                new DocField("code", String.class, "The service' code"),
                new DocField("name", String.class, "The service' name")};
    }

    private Snippet responseDocSnipper(boolean json, DocField root, DocField... docFields) {
        FieldDescriptor[] fieldDescriptors = buildFieldDescriptors(json, root, docFields);

        return responseFields(fieldDescriptors);
    }

    private Snippet requestDocSnipper(boolean json, DocField root, DocField... docFields) {
        FieldDescriptor[] fieldDescriptors = buildFieldDescriptors(json, root, docFields);

        return requestFields(fieldDescriptors);
    }

    private FieldDescriptor[] buildFieldDescriptors(boolean json, DocField root, DocField[] docFields) {
        String rootPath = root.path;

        List<DocField> docFieldsToDoc = new ArrayList<>();
        if (!json) {
            docFieldsToDoc.add(root);
        }
        Collections.addAll(docFieldsToDoc, docFields);

        return docFieldsToDoc.stream()
                .map(docField -> fieldDescriptorBuilder(docField, rootPath, json))
                .toArray(FieldDescriptor[]::new);
    }

    private FieldDescriptor fieldDescriptorBuilder(DocField docField, String rootPath, boolean json) {

        String fieldPath = (json || docField.root) ? docField.path : rootPath + "/" + docField.path;
        if (!json) {
            fieldPath = fieldPath.replaceAll("\\.", "/");
        }
        FieldDescriptor fieldDescriptor = fieldWithPath(fieldPath);
        if (!json) {
            fieldDescriptor = fieldDescriptor.type(docField.type);
        }

        return fieldDescriptor.description(docField.description);
    }


    public class DocField {
        String path;
        Class type;
        String description;
        boolean root = false;

        public DocField(String path, Class type, String description) {
            this.path = path;
            this.type = type;
            this.description = description;
        }

        public DocField(String path, Class type, String description, boolean root) {
            this.path = path;
            this.type = type;
            this.description = description;
            this.root = root;
        }
    }

}
