package com.tanibourne.blogserverhw.service;

import com.tanibourne.blogserverhw.dto.FeedRequestDto;
import com.tanibourne.blogserverhw.models.Feed;
import com.tanibourne.blogserverhw.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class FeedService {

    private final FeedRepository feedRepository;

    @Transactional
    public Feed updateFeed(Long id, FeedRequestDto requestDto){
        Feed feed = feedRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당아이디가 없습니다.")
        );

        feed.update(requestDto);
        return feed;
    }


}
