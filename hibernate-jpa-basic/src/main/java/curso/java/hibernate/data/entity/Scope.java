package curso.java.hibernate.data.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TBL_SCOPE")
public class Scope implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Esta línea especifica que la columna se llama "id" en la base de datos
    private Integer id;

    @Column(name = "scope_name")
    private String scopeName;

    @Column(name = "scope_description")
    private String scopeDescription;




    public Integer getIdScope() {
        return id;
    }

    public void setIdScope(Integer idScope) {
        this.id = idScope;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }

    public String getScopeDescription() {
        return scopeDescription;
    }

    public void setScopeDescription(String scopeDescription) {
        this.scopeDescription = scopeDescription;
    }

    @Override
    public String toString() {
        return "Scopes{" +
                "id=" + id +
                ", scopeName='" + scopeName + '\'' +
                ", scopeDescription='" + scopeDescription + '\'' +
                '}';
    }
}
