package jpa.model.DTO;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AddArtistesDTO {
    @NotNull
    @Size(min = 1, max = 10)
    private List<Long> artisteIds;
    
    public List<Long> getArtisteIds() { return artisteIds; }
    public void setArtisteIds(List<Long> ids) { this.artisteIds = ids; }
}