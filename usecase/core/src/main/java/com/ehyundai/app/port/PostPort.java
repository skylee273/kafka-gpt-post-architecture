package com.ehyundai.app.port;


import com.ehyundai.app.post.model.Post;

import java.util.List;

public interface PostPort {

    Post save(Post post);
    Post findById(Long id);
    List<Post> listByIds(List<Long> ids);
}
