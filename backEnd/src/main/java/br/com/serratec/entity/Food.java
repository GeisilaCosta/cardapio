package br.com.serratec.entity;

import br.com.serratec.dto.FoodRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;

@Table(name = "foods")
@Entity(name = "foods")
//@Getter
//@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Food {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String image;
	private Integer price;
	
    public Food() {
    }

	public Food(FoodRequestDto data) {
		this.title = data.title();
		this.image = data.image();
		this.price = data.price();
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Long getId() {

		return id;
	}

	
}
