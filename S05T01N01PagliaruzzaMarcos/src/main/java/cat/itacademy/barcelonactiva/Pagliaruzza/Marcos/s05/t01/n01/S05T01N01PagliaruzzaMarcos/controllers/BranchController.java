package cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n01.S05T01N01PagliaruzzaMarcos.controllers;

import cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n01.S05T01N01PagliaruzzaMarcos.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n01.S05T01N01PagliaruzzaMarcos.model.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping("/add")
    public ResponseEntity<BranchDTO> addBranch(@RequestBody BranchDTO branchDTO) {
        BranchDTO newBranch = branchService.addBranch(branchDTO);
        return new ResponseEntity<>(newBranch, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BranchDTO> updateBranch(@RequestBody BranchDTO branchDTO, @PathVariable int id) {
        try {
            BranchDTO updateBranch = branchService.updateBranch(branchDTO, id);
            return new ResponseEntity<>(updateBranch, HttpStatus.OK);
        } catch(RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable int id) {
        try {
            branchService.deleteBranch(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<BranchDTO> getBranch(@PathVariable int id) {
        try {
            BranchDTO branch = branchService.getBranch(id);
            return new ResponseEntity<>(branch, HttpStatus.OK);
        } catch(RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BranchDTO>> getBranches() {
        List<BranchDTO> branches = branchService.getAllBranches();
        return new ResponseEntity<>(branches, HttpStatus.OK);
    }
}
