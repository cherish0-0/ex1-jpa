package jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Category extends BaseEntity {

	@Id @GeneratedValue
	private Long id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	private Category parent;

	@OneToMany(mappedBy = "parent")
	private List<Category> child = new ArrayList<>();

	/**
	 * @JoinTable : 다대다 관계를 표현하기 위한 중간 테이블을 지정
	 * - name : 중간 테이블의 이름
	 * - joinColumns : 현재 엔티티(Category)의 기본 키를 참조하는 컬럼
	 * - inverseJoinColumns : 연관된 엔티티(Item)의 기본 키를 참조하는 컬럼
	 */
	@ManyToMany
	@JoinTable(name = "CATEGRY_ITEM",
	joinColumns = @JoinColumn(name = "CATEGORY_ID"),
	inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
	private List<Item> items = new ArrayList<>();
}
