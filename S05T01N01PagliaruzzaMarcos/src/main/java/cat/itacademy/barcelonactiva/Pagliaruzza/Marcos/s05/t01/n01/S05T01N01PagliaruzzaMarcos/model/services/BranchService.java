package cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n01.S05T01N01PagliaruzzaMarcos.model.services;

import cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n01.S05T01N01PagliaruzzaMarcos.model.domain.Branch;
import cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n01.S05T01N01PagliaruzzaMarcos.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n01.S05T01N01PagliaruzzaMarcos.model.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    public BranchDTO addBranch(BranchDTO branchDTO) {
        Branch branch = new Branch();
        branch.setNameBranch(branchDTO.getNameBranch());
        branch.setCountryBranch(branchDTO.getCountryBranch());
        branchDTO.determinateBranchType();
        branch = branchRepository.save(branch);

        return convertToDTO(branch);
    }

    public BranchDTO updateBranch(BranchDTO branchDTO, int id) {
        Optional<Branch> optionalBranch = branchRepository.findById(id);
        if(optionalBranch.isPresent()) {
            Branch branch = optionalBranch.get();
            branch.setNameBranch(branchDTO.getNameBranch());
            branch.setCountryBranch(branchDTO.getCountryBranch());
            branch = branchRepository.save(branch);
            return convertToDTO(branch);
        }
        throw new RuntimeException("Branch not found with id" + id);
    }

    public void deleteBranch(int id) {
        Optional<Branch> optionalBranch = branchRepository.findById(id);
        if(optionalBranch.isPresent()) {
            branchRepository.deleteById(id);
        } else {
            throw new RuntimeException("Branch not found with id" + id);
        }

    }

    public BranchDTO getBranch(int id) {
        Optional<Branch> optionalBranch = branchRepository.findById(id);
        if(optionalBranch.isPresent()) {
            return convertToDTO(optionalBranch.get());
        }
        throw new RuntimeException("Branch not found with id" + id);
    }

    public List<BranchDTO> getAllBranches() {
        List<Branch> branches = branchRepository.findAll();
        return branches.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private BranchDTO convertToDTO(Branch branch) {
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setPk_BranchId(branch.getPk_BranchId());
        branchDTO.setNameBranch(branch.getNameBranch());
        branchDTO.setCountryBranch(branch.getCountryBranch());
        branchDTO.setTypeBranch(branchDTO.determinateBranchType());
        return branchDTO;
    }
}
