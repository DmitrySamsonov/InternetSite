package examples.data;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Annotation @Data = @Getter + @Setter(non-final fields) + @EqualsAndHashCode + @ToString
 */
@Data
@NoArgsConstructor
public class Person {
    private int id;
    private String name;
    private final int age = 5;

}
/*
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        Objects.requireNonNull(this);
        return 5;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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
            } else if (this.getId() != other.getId()) {
                return false;
            } else if (this.getAge() != other.getAge()) {
                return false;
            } else {
                Object this$name = this.getName();
                Object other$name = other.getName();
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
        int result = result * 59 + this.getId();
        result = result * 59 + this.getAge();
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    public String toString() {
        int var10000 = this.getId();
        return "Person(id=" + var10000 + ", name=" + this.getName() + ", age=" + this.getAge() + ")";
    }

    public Person() {
    }
}
*/