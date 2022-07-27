package com.tanibourne.blogserverhw.controller;


import com.tanibourne.blogserverhw.dto.FeedRequestDto;
import com.tanibourne.blogserverhw.dto.ResponseDto;
import com.tanibourne.blogserverhw.models.Feed;
import com.tanibourne.blogserverhw.repository.FeedRepository;
import com.tanibourne.blogserverhw.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FeedController {


    private final FeedRepository feedRepository;
    private final FeedService feedService;


    @GetMapping("/api/feeds") //전체 게시글 확인
    public ResponseDto<List<Feed>> readFeed() {
        List<Feed> feedList = feedRepository.findAllByOrderByCreatedAtDesc();
        return new ResponseDto<>(true,feedList,null);
    }

    @GetMapping("/api/feeds/{id}")// 게시글 하나 확인
    public ResponseDto<Feed> readOneFeed(@PathVariable Long id) {
        Feed feed = feedRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 없습니다.")
        );
        return new ResponseDto<>(true,feed,null);

    }


    @PostMapping("/api/feeds") // 게시글 작성
    public ResponseDto<Feed> createFeed(@RequestBody FeedRequestDto requestDto) {
        return new ResponseDto<>(true, feedRepository.save(new Feed(requestDto)),null);
    }

    @PostMapping("/api/feeds/{id}") //비밀번호 확인
    public  ResponseDto<Boolean> checkPassword(@PathVariable Long id, @RequestBody FeedRequestDto requestDto) {
        boolean check = feedService.checkPassword(id,requestDto);
        return new ResponseDto<>(true,check,null);

    }

    @PutMapping("/api/feeds/{id}") //게시글 수정
    public ResponseDto<Feed> updateFeed(@PathVariable Long id, @RequestBody FeedRequestDto requestDto) {
        return new ResponseDto<>(true,feedService.updateFeed(id, requestDto),null);
    }

    @DeleteMapping("/api/feeds/{id}")
    public ResponseDto<Boolean> deleteFeed(@PathVariable Long id) {

        feedRepository.deleteById(id);

        return new ResponseDto<>(true,true,null);
    }

}
