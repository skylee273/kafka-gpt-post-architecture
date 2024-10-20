package com.ehyundai.app.controller;

import com.ehyundai.app.PostInspectUsecase;
import com.ehyundai.app.inspectedpost.model.InspectedPost;
import com.ehyundai.app.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/internal")
public class InternalController {

    private final PostInspectUsecase postInspectUsecase;

    @GetMapping
    InspectedPost inspectionTest(
        @RequestParam("title") String title,
        @RequestParam("content") String content,
        @RequestParam("categoryId") Long categoryId
    ) {
        return postInspectUsecase.inspectAndGetIfValid(Post.generate(
            0L, // userId는 검수 결과에 영향을 미치지 않으므로 아무거나 입력
            title,
            content,
            categoryId
        ));
    }
}
