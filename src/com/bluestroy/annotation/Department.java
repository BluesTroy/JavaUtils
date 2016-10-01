package com.bluestroy.annotation;

/**
 * Created by Troy on 2016/9/29.
 */
@Table("department")
public class Department {
    @Column("id")
    private String id;
    @Column("name")
    private String name;
    @Column("amount")
    private int amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
