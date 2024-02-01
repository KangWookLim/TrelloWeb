package com.example.trelloweb.user.base.repo;

import com.example.trelloweb.user.Blocked_User.entity.Blocked_UserVo;
import com.example.trelloweb.user.Blocked_User.vo.BlockedUserInfo;
import com.example.trelloweb.user.base.entity.UserVo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserJPAClassRepo{
    @PersistenceContext
    private EntityManager entityManager;


    public List<BlockedUserInfo> findBlockedUserInfoByUserUid(String userUid){
        List<BlockedUserInfo> result = new ArrayList<>();


        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserVo> criteriaQuery = criteriaBuilder.createQuery(UserVo.class);
        Root<Blocked_UserVo> blockedUserVoRoot = criteriaQuery.from(Blocked_UserVo.class);
        criteriaQuery.select(blockedUserVoRoot.get("BlockedUSERUID"));


        for(UserVo vo : entityManager.createQuery(criteriaQuery).getResultList()){
            result.add(new BlockedUserInfo(vo.getNICKNAME(), vo.getIMGURL()));
        }
        return result;
    }



}
