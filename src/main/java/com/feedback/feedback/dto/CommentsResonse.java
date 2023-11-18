package com.feedback.feedback.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CommentsResonse {
	public String id;
	public String post_id;
	public String name;
	public String email;
	public String body;
}
