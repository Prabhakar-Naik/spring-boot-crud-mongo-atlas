package com.springboot.employee.daos;

import com.springboot.employee.model.EmployeeTable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeTableDao {

    private final EntityManager entityManager;


    public List<EmployeeTable> findAllBySimpleQuery(
            String firstName,
            String lastName,
            String email){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EmployeeTable> criteriaQuery = criteriaBuilder.createQuery(EmployeeTable.class);

        // select * from employee_table
        Root<EmployeeTable> root = criteriaQuery.from(EmployeeTable.class);

        // prepare where clause
        // where firstname like '%ali%'

        Predicate firstNamePredicate = criteriaBuilder
                .like(root.get("firstName"),"%"+firstName+"%");
        Predicate lastNamePredicate = criteriaBuilder
                .like(root.get("lastName"),"%"+lastName+"%");

        Predicate emailPredicate = criteriaBuilder
                .like(root.get("email"),"%"+email+"%");

        Predicate firstNameOrLastNamePredicate = criteriaBuilder.or(
                firstNamePredicate,lastNamePredicate);

        // ==> final query  ==> select * from employee where firstName like '%ali%' or
        // lastName like '%ali%' and email like '%ali%'

        var andEmailPredicate = criteriaBuilder.and(firstNameOrLastNamePredicate,emailPredicate);

        criteriaQuery.where(andEmailPredicate);

        TypedQuery<EmployeeTable> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();

    }



    public List<EmployeeTable> findAllByCriteria(SearchRequest request){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EmployeeTable> criteriaQuery = criteriaBuilder.createQuery(EmployeeTable.class);
        List<Predicate> predicates = new ArrayList<>();

        // select from employee

        Root<EmployeeTable> root = criteriaQuery.from(EmployeeTable.class);
        if (request.getFirstName() != null){
            Predicate firstNamePredicate = criteriaBuilder
                    .like(root.get("firstName"),"%"+request.getFirstName()+"%");
                    predicates.add(firstNamePredicate);
        }

        if (request.getLastName() != null){
            Predicate lastNamePredicate = criteriaBuilder
                    .like(root.get("lastName"),"%"+request.getLastName()+"%");
            predicates.add(lastNamePredicate);
        }

        if (request.getEmail() != null){
            Predicate emailPredicate = criteriaBuilder
                    .like(root.get("email"),"%"+request.getEmail()+"%");
            predicates.add(emailPredicate);
        }

        criteriaQuery.where(criteriaBuilder.or(predicates.toArray(new Predicate[0])));

        TypedQuery<EmployeeTable> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }





}
