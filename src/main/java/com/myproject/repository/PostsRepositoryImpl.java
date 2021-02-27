package com.myproject.repository;

import com.myproject.common.Constant;
import com.myproject.common.dto.BaseDTO;
import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.common.repository.BaseRepository;
import com.myproject.common.utils.DataUtil;
import com.myproject.data.dto.PostsDTO;
import com.myproject.data.entity.PostsEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Transactional
@Repository
public class PostsRepositoryImpl extends BaseRepository implements PostsRepository {


    @Override
    public PostsDTO findPostsById(Long postsId) {
        PostsEntity postsEntity = getEntityManager().find(PostsEntity.class, postsId);
        PostsDTO postsDTO = postsEntity.toDto();
        return postsDTO;
    }

    @Override
    public ResultInsideDTO insertPosts(PostsDTO postsDTO) {
        ResultInsideDTO resultInsideDTO = new ResultInsideDTO();
        resultInsideDTO.setKey(Constant.RESPONSE_KEY.SUCCESS);
        PostsEntity postsEntity = getEntityManager().merge(postsDTO.toEntity());
        resultInsideDTO.setId(postsEntity.getPostsId());
        return resultInsideDTO;
    }

    @Override
    public ResultInsideDTO updatePostsInfo(PostsDTO postsDTO) {
        ResultInsideDTO resultInsideDTO = new ResultInsideDTO();
        resultInsideDTO.setKey(Constant.RESPONSE_KEY.SUCCESS);
        PostsEntity postsEntity = getEntityManager().find(PostsEntity.class, postsDTO.getPostsId());
        if (postsEntity != null) {
            postsEntity = getEntityManager().merge(postsDTO.toEntity());
            resultInsideDTO.setId(postsEntity.getPostsId());
        } else {
            resultInsideDTO.setKey(Constant.RESPONSE_KEY.RECORD_NOT_EXIST);
        }
        return resultInsideDTO;
    }

    @Override
    public ResultInsideDTO deletePostsById(Long postsId) {
        ResultInsideDTO resultInsideDTO = new ResultInsideDTO();
        resultInsideDTO.setKey(Constant.RESPONSE_KEY.SUCCESS);
        PostsEntity postsEntity = getEntityManager().find(PostsEntity.class, postsId);
        getEntityManager().remove(postsEntity);
        return resultInsideDTO;
    }

    @Override
    public Datatable getDatatablePosts(PostsDTO postsDTO) {
        BaseDTO baseDTO = sqlSearch(postsDTO);
        return getListDataTableBySqlQuery(baseDTO.getSqlQuery(),
                baseDTO.getParameters(), postsDTO.getPage(), postsDTO.getPageSize(),
                PostsDTO.class,
                postsDTO.getSortName(), postsDTO.getSortType());
    }

    private BaseDTO sqlSearch(PostsDTO postsDTO) {
        BaseDTO baseDTO = new BaseDTO();
        Map<String, Object> parameter = new HashMap<>();
        String sql = getSQLFromFile("posts", "getDatatablePosts");
        if (postsDTO != null) {
            if (!DataUtil.isNullOrEmpty(postsDTO.getSearchAll())) {
                sql += " And lower(p.tieude) Like lower(:searchAll) ";
                parameter.put("searchAll", DataUtil.convertSqlLike(postsDTO.getSearchAll()));
            }
        }
        sql += " ORDER BY p.tieude ASC ";
        baseDTO.setSqlQuery(sql);
        baseDTO.setParameters(parameter);
        return baseDTO;
    }
}
