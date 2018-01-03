package java20;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java20.User.MyPredicateContains;

class User {
    private String name;
    private Integer number;
    private Boolean ischeck;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getIscheck() {
        return ischeck;
    }

    public void setIscheck(Boolean ischeck) {
        this.ischeck = ischeck;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", number=" + number + ", ischeck=" + ischeck + "]";
    }

    public User(String name, Integer number, Boolean ischeck) {
        super();
        this.name = name;
        this.number = number;
        this.ischeck = ischeck;
    }

    public User() {
        super();
    }

    public static class MyPredicateContains implements Predicate {

        private String fieldName;
        private Object expected;

        @Override
        public boolean evaluate(Object object) {
            if (fieldName.equals("name")) {
                return ((User) object).getName().contains(expected.toString());
            } else if (fieldName.equals("number")) {
                return ((User) object).getNumber().equals(expected);
            } else if (fieldName.equals("ischeck")) {
                return ((User) object).getIscheck().equals(expected);
            } else {
                return false;
            }
        }

        public MyPredicateContains(String fieldName, Object expected) {
            super();
            this.fieldName = fieldName;
            this.expected = expected;
        }
    }
}

public class jv20_15_Search_Predicate_vs_Lamda {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("User Name A", 1, true));
        users.add(new User("User Name B", 2, false));
        users.add(new User("Other Name A", 3, true));
        users.add(new User("User Name C", 4, false));
        users.add(new User("User Name D", 5, false));
        users.add(new User("Other Name B", 6, true));

        // lamda 를 이용한 searching : java 8 부터 지원
        // equal searching
        List<User> result = users.stream().filter(e -> e.getName().equals("User Name B")).collect(Collectors.toList());

        System.out.println(result.toString());

        // contains searching
        result = users.stream().filter(e -> e.getName().contains("Other")).collect(Collectors.toList());
        System.out.println(result.toString());
        
        
        // predicate 를 이용한 searching
        // 라이브러리 필요
        
        MyPredicateContains predicate = new MyPredicateContains("name", "Other");
        result = (List<User>) CollectionUtils.select(users, predicate);
        System.out.println(result.toString());
        }
}
