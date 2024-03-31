package com.neo.needeachother.category.domain;

import com.neo.needeachother.starpage.domain.NEOMember;
import com.neo.needeachother.starpage.domain.StarPage;
import com.neo.needeachother.starpage.domain.StarPageId;
import com.neo.needeachother.starpage.domain.repository.StarPageRepository;
import static com.neo.needeachother.starpage.application.StarPageServiceHelper.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConfirmCategoryChangeableAdminService {

    private final StarPageRepository starPageRepository;

    public boolean isChangeableCategoryBy(String email, StarPageId starPageId){
        StarPage foundStarPage = findExistingStarPage(starPageRepository, starPageId);
        foundStarPage.isChangeableBy(NEOMember.of(email));
        return true;
    }
}
