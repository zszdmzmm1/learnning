package day0628.annotation;

import java.lang.reflect.Field;


public class Account {
    @Range
    private String name;
    private String password;

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void check(Account account) throws IllegalAccessException {
        Field[] fields = account.getClass().getDeclaredFields();
        for (Field field : fields) {
            Range range = field.getAnnotation(Range.class);
            if (range != null) {
                Object value = field.get(account);
                if (value instanceof String s) {
                    if(account.name.length() < range.minLen() || account.name.length()>range.maxLen()){
                        throw new IllegalAccessException("账号长度不符合要求！");
                    }
                    char[] cName = account.name.toCharArray();
                    for (char c : cName) {
                        if(c < range.numMin() || (c > range.numMax() && c > range.charMin()) || c > range.charMax()){
                            throw new IllegalAccessException("请输入中英文或数字！");
                        }
                    }
                }

            }
        }
    }

    public Account creatNewAccount(String name, String password) throws IllegalAccessException {
        Account account = new Account(name, password);
        check(account);
        System.out.println("创建成功。");
        return account;
    }

}
