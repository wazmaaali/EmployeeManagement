package com.itsutra.employeemgmt.controllers;

import com.itsutra.employeemgmt.controllers.dto.RoleDTO;
import com.itsutra.employeemgmt.enitity.Role;
import com.itsutra.employeemgmt.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        List<RoleDTO> roleDTOs = roles.stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok().body(roleDTOs);
    }
    @PostMapping("/")
    public ResponseEntity<Void> addEmployee(@RequestBody RoleDTO roleDTO) {
        Role role = convertToEntity(roleDTO);
        roleService.addRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public RoleDTO convertToDto(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName());
//        roleDTO.setEmployees(role.getEmployees());
        return roleDTO;

    }

    public Role convertToEntity(RoleDTO roleDTO) {

        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setName(roleDTO.getName());
//        role.setEmployees(roleDTO.getEmployees());
        return role;
    }
}
