package net.data.sekolah.service;

import net.data.sekolah.model.Kelas;
import net.data.sekolah.repositories.KelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *
 * @since 16/01/2021
 * @author fahna
 * */
@Service
public class KelasService {

    @Autowired
    private KelasRepository kelasRepository;


    public List<Kelas> listAll () {
        return kelasRepository.findAll();
    }

    public void save (Kelas kelas) {
        kelasRepository.save(kelas);
    }

    public Kelas get (Integer id) {
        return kelasRepository.findById(id).get();
    }

    public void delete(Integer id) {
        kelasRepository.deleteById(id);
    }
}
