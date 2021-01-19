package net.data.sekolah.controller;

import net.data.sekolah.model.Kelas;
import net.data.sekolah.model.Siswa;
import net.data.sekolah.service.KelasService;
import net.data.sekolah.service.SiswaService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private KelasService kelasService;

    @Autowired
    private SiswaService siswaService;

    //HomePage
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Kelas> listKelas = kelasService.listAll();
        model.addAttribute("listKelas", listKelas);

        return "index";
    }

    //Menampilkan Siswa yang ada didalam kelas_ID
    @RequestMapping("/kelas/{id}")
    public String viewListSiswa(@PathVariable(name = "id") Integer id, Model model) {
        List<Siswa> siswaList = siswaService.getListKelasId(id);
        model.addAttribute("siswaList",siswaList);
        return "data_siswa";
    }
    //Buat Kelas baru
    @RequestMapping("/kelasBaru")
    public String showNewKelasForm(Model model) {
        Kelas kelas = new Kelas();
        model.addAttribute("kelas",kelas);

        return "new_kelas";
    }

    //menyimpan Data input Kelas Baru
    @PostMapping(value = "/saveKelas")
    public String saveKelas(@ModelAttribute("kelas") Kelas kelas) {
        kelasService.save(kelas);

        return "redirect:/";
    }

    //Edit Nama kelas
    @RequestMapping("/editKelas/{id}")
    public ModelAndView showEditKelasForm(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("edit_Kelas");

        Kelas kelas = kelasService.get(id);
        mav.addObject("kelas",kelas);

        return mav;
    }

    //delete Kelas
    @RequestMapping("/deleteKelas/{id}")
    public String deleteKelas(@PathVariable(name = "id") Integer id) {
        try {
            kelasService.delete(id);
        } catch (Exception e) {
            System.out.println("Cant Delete");
        }

        return "redirect:/";
    }

    //buat siswa baru
    @RequestMapping("/siswaBaru")
    public String showNewSiswaForm(Model model) {
        Siswa siswa = new Siswa();
        model.addAttribute("siswa", siswa);

        return "new_siswa";
    }
    //menyimpan Data input Siswa Baru
    @PostMapping(value = "/saveSiswa")
    public String saveSiswa(@ModelAttribute("siswa") Siswa siswa) {
        siswaService.save(siswa);

        return "redirect:/";
    }

    //Delete Siswa
    @RequestMapping("/editSiswa/{id}")
    public ModelAndView showEditSiswaForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_siswa");

        Siswa siswa = siswaService.get(id);
        mav.addObject("siswa", siswa);

        return mav;
    }

    @RequestMapping("/deleteSiswa/{id}")
    public String deleteSiswa(@PathVariable(name = "id") Long id) {
        siswaService.delete(id);

        return "redirect:/";
    }


    @GetMapping("/403")
    public String error403() {
        return "403";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
