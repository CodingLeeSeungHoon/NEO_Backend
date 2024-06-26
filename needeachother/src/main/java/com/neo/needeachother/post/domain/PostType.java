package com.neo.needeachother.post.domain;

import com.neo.needeachother.category.domain.ContentType;
import com.neo.needeachother.common.exception.NEOUnexpectedException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum PostType {
    COMMON("C", ContentType.TypeCode.COMMON),
    ALBUM("A", ContentType.TypeCode.ALBUM),
    GOLD_BALANCE("G", ContentType.TypeCode.GOLD_BALANCE),
    VOTE("V", ContentType.TypeCode.VOTE);

    // 카테고리의 컨텐츠 타입 요약 심볼(DB 데이터)
    private final String contentTypeSummarizedSymbol;

    // 카테고리 앞 접두사
    private final String prefixCategoryId;

    public static final class TypeCode{
        public static final String COMMON = "CO";
        public static final String ALBUM = "AL";
        public static final String GOLD_BALANCE = "GO";
        public static final String VOTE = "VO";
    }

    public static PostType convertToPostType(String dbSymbol){
        return Arrays.stream(PostType.values())
                .filter(postType -> postType.getContentTypeSummarizedSymbol().equals(dbSymbol))
                .findAny()
                .orElseThrow(() -> new NEOUnexpectedException("경고 : 예상하지 못한 카테고리 컨텐츠 타입값이 저장됨"));
    }
}
