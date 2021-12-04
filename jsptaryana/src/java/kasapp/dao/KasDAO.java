/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasapp.dao;

import java.util.List;
import kasapp.model.Anggota;

/**
 *
 * @author acer
 */
public interface KasDAO {
    List<Anggota> get();
    boolean save(Anggota anggota);
    Anggota getSinggle(int id);
    boolean update(Anggota anggota);
    boolean delete(int id);
}
