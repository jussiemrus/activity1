package com.fimc.activity1.people.resource;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PeopleResponse implements Serializable{
	private String firstName;
	private String lastName;
	private String birthDate;

}
