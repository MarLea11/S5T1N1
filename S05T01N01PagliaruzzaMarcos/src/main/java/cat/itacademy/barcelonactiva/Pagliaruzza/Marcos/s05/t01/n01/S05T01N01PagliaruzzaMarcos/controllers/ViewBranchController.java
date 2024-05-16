package cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n01.S05T01N01PagliaruzzaMarcos.controllers;

import cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n01.S05T01N01PagliaruzzaMarcos.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n01.S05T01N01PagliaruzzaMarcos.model.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("view/branch")
public class ViewBranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping("/add")
    public String showAddBranch(Model model) {
        model.addAttribute("branch", new BranchDTO());
        return "add";
    }

    @PostMapping(value = "/add", consumes = "application/x-www-form-urlencoded")
    public String addBranch(@ModelAttribute ("branch") BranchDTO branchDTO) {
        BranchDTO newBranch = branchService.addBranch(branchDTO);
        if(newBranch!=null) {
            return "redirect:/view/branch/list";
        }
        return "add";
    }

    @GetMapping("/getAll")
    public String getListBranches(Model model) {
        List<BranchDTO> branches = branchService.getAllBranches();
        model.addAttribute("branches", branches);
        return "list";
    }

}
