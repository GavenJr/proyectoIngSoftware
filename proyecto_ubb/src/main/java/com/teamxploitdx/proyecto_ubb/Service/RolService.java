package com.teamxploitdx.proyecto_ubb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teamxploitdx.proyecto_ubb.Model.Rol;
import com.teamxploitdx.proyecto_ubb.Repository.RolRepository;
@Service
public class RolService {
    
        private RolRepository rolRepository;
    
        public RolService(RolRepository rolRepository) {
            this.rolRepository = rolRepository;
        }
    
        public List<Rol> findAllRol() {
            return rolRepository.findAll();
        }
    
        public Optional<Rol> findRolById(int id) {
            return rolRepository.findById(id);
        }

        public void saveRol(Rol rol) {
            rolRepository.save(rol);
        
        }

        public void deleteRol(int id) {
            rolRepository.deleteById(id);
        }
    }
