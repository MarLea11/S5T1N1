package cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n01.S05T01N01PagliaruzzaMarcos.model.dto;

import java.util.Arrays;
import java.util.List;

public class BranchDTO {

    private int pk_BranchId;
    private String nameBranch;
    private String countryBranch;
    private String typeBranch;

    private String errorMessage;
    private final List<String> COUNTRIES_UE = Arrays.asList("AUSTRIA, BELGIUM, BULGARIA, CROATIA, CYPRUS, CZECH_REPUBLIC, DENMARK, ESTONIA, SPAIN, FINLAND, FRANCE, GERMANY, GREECE, HUNGARY, IRELAND, ITALY, LATVIA, LITHUANIA, LUXEMBOURG, MALTA, NETHERLANDS, POLAND, PORTUGAL, ROMANIA, SLOVAKIA, SLOVENIA, SWEDEN, SWITZERLAND, TURKEY");

    public BranchDTO() {

    }

    public BranchDTO(String nameBranch, String countryBranch, String typeBranch) {
        this.nameBranch = nameBranch;
        this.countryBranch = countryBranch;
        this.typeBranch = typeBranch;
    }

    public String determinateBranchType() {
        return COUNTRIES_UE.contains(countryBranch) ? "Inside UE" : "Outside UE";
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

    public String getTypeBranch() {
        return typeBranch;
    }

    public void setTypeBranch(String typeBranch) {
        this.typeBranch = typeBranch;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

