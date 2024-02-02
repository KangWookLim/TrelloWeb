package com.example.trelloweb.user.base.repo;

import com.example.trelloweb.user.Blocked_User.entity.Blocked_UserVo;
import com.example.trelloweb.user.Blocked_User.vo.BlockedUserInfo;
import com.example.trelloweb.user.base.entity.UserVo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserJPAClassRepo{
    @PersistenceContext
    private EntityManager entityManager;

    public List<BlockedUserInfo> findBlockedUserInfoByUserUid(String userUid) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BlockedUserInfo> criteriaQuery = criteriaBuilder.createQuery(BlockedUserInfo.class);
        Root<UserVo> userRoot = criteriaQuery.from(UserVo.class);
        Join<UserVo, Blocked_UserVo> blockedUserJoin = userRoot.join("blocked_userVoList", JoinType.INNER);

        Predicate userUidPredicate = criteriaBuilder.equal(blockedUserJoin.get("uservo").get("useruid"), userUid);

        criteriaQuery.select(criteriaBuilder.construct(
                BlockedUserInfo.class,
                userRoot.get("useruid"),
                userRoot.get("NICKNAME"),
                userRoot.get("IMGURL")
        ));
        criteriaQuery.where(userUidPredicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
