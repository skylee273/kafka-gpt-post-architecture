package com.ehyundai.app.port;


import com.ehyundai.app.inspectedpost.model.AutoInspectionResult;
import com.ehyundai.app.post.model.Post;

public interface PostAutoInspectPort {

    AutoInspectionResult inspect(Post post, String categoryName);

}
