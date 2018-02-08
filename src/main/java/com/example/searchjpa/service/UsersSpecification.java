package com.example.searchjpa.service;

import com.example.searchjpa.DTO.*;
import com.example.searchjpa.model.Users;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

public class UsersSpecification {
    public static Specification<Users> containsTextInAttributes2(Map<String, String> attributes) {

        return (root, query, builder) -> builder.or(root.getModel().getDeclaredSingularAttributes().stream()
                .filter(a -> attributes.containsKey(a.getName()))
                .map(a -> builder.like(root.get(a.getName()), attributes.get(a.getName()))
                )
                .toArray(Predicate[]::new)
        );
    }


    public static Specification<Users> containsTextInAttributeseqUsePostOject(RootObject rootObject) {
        return new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                final Collection<Predicate> predicates = new ArrayList<>();
                Predicate cbp = cb.and(predicates.toArray(new Predicate[predicates.size()]));
                for (int i = 0; i < rootObject.getItems().size(); i++) {
                    Data data = rootObject.getItems().get(i).getData();
                    if (data != null && data.getQuery() != null && data.getQuery().getFilter() != null) {
                        Filter filter = data.getQuery().getFilter();
                        if (filter.getAnd() != null)
                            cbp = addFilterAnd(predicates, cb, root, filter);
                        if (filter.getOr() != null)
                            cbp = addFilterOr(predicates, cb, root, filter);
                    }
                }
                return cbp;
            }

            private Predicate addFilterOr(Collection<Predicate> predicates, CriteriaBuilder cb, Root<Users> root, Filter filter) {
                Predicate cbp = null;
                ArrayList<Or> listFilterOr = filter.getOr();
                final Collection<Predicate> predicatesFilterOr = new ArrayList<>();

                for (int j = 0; j < listFilterOr.size(); j++) {
                    if (listFilterOr.get(j).getFilter() != null) {
                        String value = filter.getOr().get(j).getFilter().getParameter().getEq();
                        String name = filter.getOr().get(j).getFilter().getAttribute().getName();
                        predicatesFilterOr.add(cb.equal(root.get(name), value));
                        Predicate cpFilterOr = cb.or(predicatesFilterOr.toArray(new Predicate[predicatesFilterOr.size()]));
                        if (predicatesFilterOr.size() > 0) {
                            if (cbp == null)
                                cbp = cpFilterOr;
                            else
                                cbp = cb.or(cbp,cpFilterOr);
                            predicatesFilterOr.clear();
                        }
                    }
                    if (listFilterOr.get(j).getAnd() != null) {
                        ArrayList<And> listFilterOrAnd = listFilterOr.get(j).getAnd();
                         Collection<Predicate> predicatesFilterOrAnd = new ArrayList<>();
                        for (int k = 0; k < listFilterOrAnd.size(); k++) {
                            predicatesFilterOrAnd.add(cb.equal(root.get(listFilterOrAnd.get(k).getFilter().getAttribute().getName()), listFilterOrAnd.get(k).getFilter().getParameter().getEq()));
                        }
                        if (predicatesFilterOrAnd.size() > 0) {
                            Predicate cpFilterOrAnd = cb.and(predicatesFilterOrAnd.toArray(new Predicate[predicatesFilterOrAnd.size()]));
                            if (cbp == null)
                                cbp = cpFilterOrAnd;
                            else
                                cbp = cb.or(cbp,cpFilterOrAnd );
                        }
                    }
                    if (listFilterOr.get(j).getOr() != null) {
                        ArrayList<Or> listFilterOrOr = listFilterOr.get(j).getOr();
                         Collection<Predicate> predicatesFilterOrOr = new ArrayList<>();
                        for (int k = 0; k < listFilterOrOr.size(); k++) {
                            predicatesFilterOrOr.add(cb.equal(root.get(listFilterOrOr.get(k).getFilter().getAttribute().getName()), listFilterOrOr.get(k).getFilter().getParameter().getEq()));
                        }
                        Predicate cpFilterOrOr = cb.or(predicatesFilterOrOr.toArray(new Predicate[predicatesFilterOrOr.size()]));
                        if (predicatesFilterOrOr.size() > 0)
                            if (cbp == null)
                                cbp = cpFilterOrOr;
                            else
                                cbp = cb.or(cpFilterOrOr, cbp);
                    }
                }

                return cbp;
            }

            private Predicate addFilterAnd(Collection<Predicate> predicates, CriteriaBuilder cb, Root<Users> root, Filter filter) {
                Predicate cbp = null;
                ArrayList<And> listFilterAnd = filter.getAnd();
                 Collection<Predicate> predicatesFilterAnd = new ArrayList<>();

                int k1 = 0;
                int sizeAndAnd = 0;
                int sizeAndOr = 0;
                for (int j = 0; j < listFilterAnd.size(); j++) {
                    if (listFilterAnd.get(j).getFilter() != null) {
                        String value = filter.getAnd().get(j).getFilter().getParameter().getEq();
                        String name = filter.getAnd().get(j).getFilter().getAttribute().getName();
                        predicatesFilterAnd.add(cb.equal(root.get(name), value));
                        Predicate cpFilterAnd = cb.and(predicatesFilterAnd.toArray(new Predicate[predicatesFilterAnd.size()]));
                        if (predicatesFilterAnd.size() > 0) {
                            if (cbp == null)
                                cbp = cpFilterAnd;
                            else
                                cbp = cb.and(cpFilterAnd, cbp);
                            predicatesFilterAnd.clear();
                        }
                    }
                    if (listFilterAnd.get(j).getAnd() != null) {
                        ArrayList<And> listFilterAnd_listAnd = listFilterAnd.get(j).getAnd();
                        sizeAndAnd = listFilterAnd_listAnd.size();
                         Collection<Predicate> predicatesFilterAndAnd = new ArrayList<>();
                        for (int k = 0; k < sizeAndAnd; k++) {
                            predicatesFilterAndAnd.add(cb.equal(root.get(listFilterAnd_listAnd.get(k).getFilter().getAttribute().getName()), listFilterAnd_listAnd.get(k).getFilter().getParameter().getEq()));
                        }
                        if (predicatesFilterAndAnd.size() > 0) {
                            Predicate cpFilterAndAnd = cb.and(predicatesFilterAndAnd.toArray(new Predicate[predicatesFilterAndAnd.size()]));
                            if (cbp == null)
                                cbp = cpFilterAndAnd;
                            else
                                cbp = cb.and(cpFilterAndAnd, cbp);
                        }
                    }
                    if (listFilterAnd.get(j).getOr() != null) {
                        ArrayList<Or> listFilterAndOr = listFilterAnd.get(j).getOr();
                        sizeAndOr = listFilterAndOr.size();
                         Collection<Predicate> predicatesFilterAndOr = new ArrayList<>();
                        for (int k = 0; k < sizeAndOr; k++) {
                            predicatesFilterAndOr.add(cb.equal(root.get(listFilterAndOr.get(k).getFilter().getAttribute().getName()), listFilterAndOr.get(k).getFilter().getParameter().getEq()));
                        }
                        Predicate cpFilterOrOr = cb.or(predicatesFilterAndOr.toArray(new Predicate[predicatesFilterAndOr.size()]));
                        if (predicatesFilterAndOr.size() > 0)
                            if (cbp == null)
                                cbp = cpFilterOrOr;
                            else
                                cbp = cb.and(cpFilterOrOr, cbp);
                    }
                }

                return cbp;
            }
        };
    }


    public static Specification<Users> containsTextInAttributeseq(List<String> attributes) {
        return new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                final Collection<Predicate> predicates = new ArrayList<>();
                for (int i = 0; i < attributes.size(); i++) {
                    final Predicate firstNmPredicate = cb.equal(root.get("id"), Integer.parseInt(attributes.get(i)));
                    predicates.add(firstNmPredicate);
                }
                return cb.or(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }


    public static Specification<Users> containsTextInNameSimple2(String text) {
        if (!text.contains("%")) {
            text = "%" + text + "%";
        }
        String finalText = text;
        return (root, query, builder) -> builder.or(
                builder.like(root.get("lastname"), finalText),
                builder.like(root.get("firstname"), finalText)
        );
    }

    public static Specification<Users> containsTextInAttributes(String text, List<String> attributes) {
        text = text + "%";

        String finalText = text;
        return (root, query, builder) -> builder.or(root.getModel().getDeclaredSingularAttributes().stream()
                .filter(a -> attributes.contains(a.getName()))
                .map(a -> builder.like(root.get(a.getName()), finalText))
                .toArray(Predicate[]::new)
        );
    }

    public static Specification<Users> containsTextInNameSimple1(String text) {
        return containsTextInAttributes(text, Arrays.asList("lastname", "firstname"));
    }


    public static Specification<Users> textInAllColumnsWithString(String text) {

        if (!text.contains("%")) {
            text = "%" + text + "%";
        }
        final String finalText = text;

        return new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> cq, CriteriaBuilder builder) {
                return builder.or(root.getModel().getDeclaredSingularAttributes().stream().filter(a -> {
                            if (a.getJavaType().getSimpleName().equalsIgnoreCase("string")) {
                                return true;
                            } else {
                                return false;
                            }
                        }).map(a -> builder.like(root.get(a.getName()), finalText)
                        ).toArray(Predicate[]::new)
                );
            }
        };
    }

}
