package com.pages.controller;

import static com.epages.restdocs.apispec.ResourceDocumentation.resource;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;

import com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper;
import com.epages.restdocs.apispec.ResourceSnippetParameters;
import com.pages.controller.dto.BoardPostRequest;
import com.pages.restdocs.ControllerTestConfig;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(BoardController.class)
public class BoardControllerTest extends ControllerTestConfig {

    @MockBean
    BoardController boardController;

    @Test
    @DisplayName("관심사 목록 리스트 조회")
    void getInterestAll() throws Exception {
        //given
        when(boardController.addPost(BoardPostRequest.sample()))
            .thenReturn(
                Map.of(
                    "result", "요청결과",
                    "boardId", "게시글번호"
                )
            );

        //then
        ResultActions resultActions = mockMvc
            .perform(
                RestDocumentationRequestBuilders.post("/board/v0")
                    .content(
                        mapper.writeValueAsString(BoardPostRequest.sample())
                    )
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
            .andDo(
                MockMvcRestDocumentationWrapper.document("board-docs",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint()),
                    resource(
                        ResourceSnippetParameters.builder()
                            .description("관심사 목록 리스트 조회")
                            .requestFields(
                                fieldWithPath("title").description("테스트"),
                                fieldWithPath("contents").description("테스트"),
                                fieldWithPath("isAnonymous").description("테스트"),
                                fieldWithPath("isReservation").description("테스트"),
                                fieldWithPath("reservedAt").description("테스트")
                            )
                            .responseFields(
//                            fieldWithPath("[].idx").description("idx"),
//                            fieldWithPath("[].name").description("이상형 명칭"),
//                            fieldWithPath("[].emojiCode").description("이모티콘 코드")
                            )
                            .build()
                    )
                )
            );

        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }


}
