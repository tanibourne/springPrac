package com.tanibourne.week03_first.service;

import com.tanibourne.week03_first.Dto.MemoRequestDto;
import com.tanibourne.week03_first.domain.Memo;
import com.tanibourne.week03_first.domain.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto){

        Memo memo = memoRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 아이디가 없습니다.")
        );

        memo.update(requestDto);

        return memo.getId();

    }
}
