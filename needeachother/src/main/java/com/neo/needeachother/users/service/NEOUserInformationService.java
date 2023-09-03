package com.neo.needeachother.users.service;

import com.neo.needeachother.users.dto.NEOAdditionalFanInfoRequest;
import com.neo.needeachother.users.dto.NEOChangeableInfoDTO;
import com.neo.needeachother.users.dto.NEOAdditionalStarInfoRequest;
import com.neo.needeachother.users.dto.NEOUserInformationDTO;
import com.neo.needeachother.users.enums.NEOUserOrder;
import org.springframework.http.ResponseEntity;

public interface NEOUserInformationService {
     ResponseEntity<NEOUserInformationDTO> doCreateNewStarInformationOrder(NEOAdditionalStarInfoRequest createStarInfoRequest, NEOUserOrder userOrder);
     ResponseEntity<NEOUserInformationDTO> doCreateNewFanInformationOrder(NEOAdditionalFanInfoRequest createFanInfoRequest, NEOUserOrder userOrder);
     ResponseEntity<?> doGetUserInformationOrder(String userID, NEOUserOrder userOrder);
     ResponseEntity<?> doGetPublicUserInformationOrder(String userID, NEOUserOrder userOrder);
     ResponseEntity<NEOUserInformationDTO> doChangePartialInformationOrder(String userID, NEOUserOrder userOrder, NEOChangeableInfoDTO changeInfoDto);
     ResponseEntity<?> doDeleteUserInformationOrder(String userID, NEOUserOrder userOrder);
     ResponseEntity<NEOUserInformationDTO> doGetStarInformationOrder(String userID, boolean isPrivacy, boolean isDetail, NEOUserOrder userOrder);
     ResponseEntity<NEOUserInformationDTO> doGetFanInformationOrder(String userID, boolean isPrivacy, NEOUserOrder userOrder);
}
