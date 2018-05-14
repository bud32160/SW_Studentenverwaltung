package entities;

import enumerations.EAquisition;
import enumerations.ERole;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Student.class)
public abstract class Student_ {

	public static volatile SingularAttribute<Student, String> firstName;
	public static volatile SingularAttribute<Student, String> lastName;
	public static volatile SingularAttribute<Student, Address> address;
	public static volatile SingularAttribute<Student, Major> major;
	public static volatile SingularAttribute<Student, EAquisition> aquisition;
	public static volatile SingularAttribute<Student, String> ID;
	public static volatile SingularAttribute<Student, String> userId;
	public static volatile SingularAttribute<Student, ERole> eRole;
	public static volatile SingularAttribute<Student, String> matrikelNumber;

}

