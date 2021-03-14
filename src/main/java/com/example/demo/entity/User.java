package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //Spefifies the class is an entity
@Table(name="users2")
/*Specifies the primary table for the annotated entity.
Additionaltables may be specified using SecondaryTable or SecondaryTables annotation.*/
public class User implements Serializable {
	private static final long serialVersionUID = -6790710012334909957L;
	/*Acerca de @ID
	Specifies the primary key of an entity.The field or property to which the Id annotation 
	is applied should be one of the following types: any Java primitive type;any primitive wrapper type;
	String; java.util.Date; java.sql.Date; java.math.BigDecimal; java.math.BigInteger. 
	The mapped column for the primary key of the entity is assumed to be the primary key of the primary table.
	If no Column annotation is specified, 
	the primary key column name is assumed to be the name of the primary key property or field. 
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	/*Acerca de los campos
	 * nullable=false significa que ese campo no admite nulos si no se especifica por defecto es true
	 * length=longitud maxima 70 
	 * */
	@Column(length = 70,nullable = false)
	private String name;
	@Column(length = 70,nullable = false)
	private String last_name;
	@Column(length = 70,nullable = false)
	private String hobbie;
	
	public User() {
		//Default constructor
	}
	
	public User(int ID, String name, String last_name, String hobbie) {
		this.ID = ID;
		this.name = name;
		this.last_name = last_name;
		this.hobbie = hobbie;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getHobbie() {
		return hobbie;
	}

	public void setHobbie(String hobbie) {
		this.hobbie = hobbie;
	}
	
	

}
