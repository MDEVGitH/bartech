/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paymentchain.song.respository;

import com.paymentchain.song.entities.Song;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author sotobotero
 */
public interface SongRepository extends JpaRepository<Song, Long> {

    @Query("SELECT s FROM Song s WHERE s.isPlayed = false")
    List<Song> findNotPlayed();

}
