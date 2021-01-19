package net.data.sekolah.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "kelas")
public class Kelas {

    @Id
    @Column(name = "id_kelas")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama_kelas")
    @JsonProperty("nama_kelas")
    private String name;

    @OneToMany(mappedBy = "kelas")
    private Set<Siswa> siswa = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Siswa> getSiswa() {
        return siswa;
    }

    public void setSiswa(Set<Siswa> siswa) {
        this.siswa = siswa;
    }
}
