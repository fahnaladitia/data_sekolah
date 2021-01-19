package net.data.sekolah.service;

import net.data.sekolah.model.Siswa;
import net.data.sekolah.repositories.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiswaService {

    @Autowired
    private SiswaRepository siswaRepository;

    public List<Siswa> listAll () {
        return siswaRepository.findAll();
    }

    public void save (Siswa siswa) {
        siswaRepository.save(siswa);
    }

    public Siswa get (Long id) {
        return siswaRepository.findById(id).get();
    }

    public void delete (Long id) {
        siswaRepository.deleteById(id);
    }

    public List<Siswa> getListKelasId(Integer id) {
        return siswaRepository.getListByKelasId(id);
    }
}
