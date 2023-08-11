//package com.example.springswaggerpages.restdocs;
//
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.restdocs.RestDocumentationContextProvider;
//import org.springframework.restdocs.RestDocumentationExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.filter.CharacterEncodingFilter;
//
//@AutoConfigureMockMvc
//@AutoConfigureRestDocs
//@ExtendWith({RestDocumentationExtension.class})
//public abstract class ControllerTestConfig {
//
//    @Autowired
//    protected WebApplicationContext ctx;
//
//    @Autowired
//    protected ObjectMapper mapper = new ObjectMapper();
//
//
//    protected MockMvc mockMvc;
//
//
//    @BeforeEach
//    void setUp(final RestDocumentationContextProvider restDocumentation) {
//        mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
//            .apply(documentationConfiguration(restDocumentation))
//            .addFilters(new CharacterEncodingFilter("UTF-8", true))
//            .alwaysDo(print())
//            .build();
//        // 이거 안쓰면 LocalDateTime 이나 zdt 못씀 >> GSON 쓰면 더 지옥이 됨
//        mapper.registerModule(new JavaTimeModule()); // Register the JSR-310 module;
//    }
//}
