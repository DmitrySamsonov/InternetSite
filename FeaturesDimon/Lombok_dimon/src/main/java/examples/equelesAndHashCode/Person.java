package examples.equelesAndHashCode;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Person {
    private int id;
    private String name;
    private int age;
}

/*
 public Person() {
    }
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Person)) {
            return false;
        } else {
            Person other = (Person)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.id != other.id) {
                return false;
            } else if (this.age != other.age) {
                return false;
            } else {
                Object this$name = this.name;
                Object other$name = other.name;
                if (this$name == null) {
                    if (other$name == null) {
                        return true;
                    }
                } else if (this$name.equals(other$name)) {
                    return true;
                }
                return false;
            }
        }
    }
    protected boolean canEqual(Object other) {
        return other instanceof Person;
    }
    public int hashCode() {
        int PRIME = true;
        int result = 1;
        int result = result * 59 + this.id;
        result = result * 59 + this.age;
        Object $name = this.name;
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        return result;
    }
 */
