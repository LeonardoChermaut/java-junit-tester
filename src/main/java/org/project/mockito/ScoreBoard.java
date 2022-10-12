package org.project.mockito;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ScoreBoard {

    //Primitive Obsession
    private Integer wins;
    private Integer losses;
    private Integer ties;

    public ScoreBoard(){
        wins = 0;
        losses = 0;
        ties = 0;
    }

    public void incrementWins(){
        wins++;
    }

    public void incrementLosses(){
        losses++;
    }

    public void incrementTie(){
        ties++;
    }
}
