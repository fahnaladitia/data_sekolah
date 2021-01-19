package net.data.sekolah.repositories;

import net.data.sekolah.model.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SiswaRepository extends JpaRepository<Siswa,Long> {


    @Query(value = "SELECT * FROM siswa WHERE kelas_id =:kelas", nativeQuery = true)
    public List<Siswa> getListByKelasId(@Param("kelas") Integer kelas);
}
