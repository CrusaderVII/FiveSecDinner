package egor.family.five_sec_dinner_service.util.exception;

import egor.family.five_sec_dinner_service.dao.model.User;

public class NoSuchUserException extends NoSuchDataException{

    public NoSuchUserException(String attribute) {
        super(User.class.getName(), attribute);
    }
}
