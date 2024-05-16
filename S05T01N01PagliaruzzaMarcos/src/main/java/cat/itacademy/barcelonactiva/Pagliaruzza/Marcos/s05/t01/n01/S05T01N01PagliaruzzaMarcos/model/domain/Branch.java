package cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n01.S05T01N01PagliaruzzaMarcos.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_BranchId;
    private String nameBranch;
    private String countryBranch;

    public Branch() {

    }

    public Branch(String nameBranch, String countryBranch) {
        this.nameBranch = nameBranch;
        this.countryBranch = countryBranch;
    }

    public int getPk_BranchId() {
        return pk_BranchId;
    }

    public void setPk_BranchId(int pk_BranchId) {
        this.pk_BranchId = pk_BranchId;
    }

    public String getNameBranch() {
        return nameBranch;
    }

    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }

    public String getCountryBranch() {
        return countryBranch;
    }

    public void setCountryBranch(String countryBranch) {
        this.countryBranch = countryBranch;
    }
}
