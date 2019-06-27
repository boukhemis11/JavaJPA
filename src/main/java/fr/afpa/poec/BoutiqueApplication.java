package fr.afpa.poec;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.afpa.poec.dao.ItemRepo;
import fr.afpa.poec.entity.Category;
import fr.afpa.poec.entity.Image;
import fr.afpa.poec.entity.Item;
import fr.afpa.poec.entity.Warranty;

@SpringBootApplication
public class BoutiqueApplication implements CommandLineRunner {
	@Autowired
	private ItemRepo irepo;
	private Log log = LogFactory.getLog(BoutiqueApplication.class); 
	
	public static void main(String[] args) {
		SpringApplication.run(BoutiqueApplication.class, args);
	}
	private void log(String prefix,String val) {
		log.info("********************"+"###  "+prefix+" ### "+val);
	}
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Long[] ids = new Long[5];
		for (int i = 0 ; i < 5 ; i++) {
			Image img = new Image("alt"+i, "path"+i);
			Category cat = new Category("cname"+i, "ccode"+i, "cdescription"+i);
			Warranty war = new Warranty("summary"+i, "fullText"+i);
			Item item = new Item("iname"+i, "icode"+i, "idescription"+i, 10.0+i);
			item.addImage(img);
			item.addCategory(cat);
			item.setWarranty(war);
			item = irepo.save(item);
			ids[i] = item.getId();
		}
		List<Item> list = (List<Item>)irepo.findAll();
		for (Item i:list) {
			log("FIRST",i.toString());
		}
		Category cat = new Category("CAT_NAME", "CAT_CODE", "CAT_DESC");
		Item item = irepo.findById(ids[0]).get();
		item.addCategory(cat);
		irepo.save(item);
		item = irepo.findById(ids[1]).get();
		item.addCategory(cat);
		irepo.save(item);
		list = (List<Item>)irepo.findAll();
		for (Item i:list) {
			log("SECOND",i.toString());
		}

	
		Image img = new Image("dalt", "dpath");
		cat = new Category("dcname", "dccode", "dcdescription");
		Warranty war = new Warranty("dsummary", "dfullText");
		cat = new Category("D_CAT_NAME", "D_CAT_CODE", "D_CAT_DESC");
		item = new Item("diname", "dicode", "didescription", 10.0);
		item.addCategory(cat);
		item.addImage(img);
		item.setWarranty(war);
		
		long id = irepo.save(item).getId();
		if (irepo.findById(id).isPresent()) {
			log("AVANT DELETE","Le item de id = "+id+" est là");
		} else {
			log("AVANT DELETE","Le item de id = "+id+ " existe pas");
		}
		irepo.delete(item);
		if (irepo.findById(id).isPresent()) {
			log("APRES DELETE","Le item de id = "+id+" est là");
		} else {
			log("APRES DELETE","Le item de id = "+id+ " existe pas");
		}
	}
	
}


