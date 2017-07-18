package com.didispace.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/cachePage")
	public String cachePage(@RequestParam String content,Model model) {  
		model.addAttribute("content", content);
		return "cachePage";   
	}  
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello(@RequestParam(required = false) String username, String sex) {
		return "Hello World" + username + "--" + sex;
	}

	// “/index”和“/”一样
	@RequestMapping("/index")
	public String index(Model model) {
		User user = new User();
		user.setAge(18);
		user.setName("木头");
		user.setSex("男");
		user.setFlg(false);
		user.setCreateTime(new Date());

		User user2 = new User();
		user2.setAge(20);
		user2.setName("猪头");
		user2.setSex("女");
		user2.setFlg(false);
		user2.setCreateTime(new Date());

		List userList = new ArrayList<User>();
		userList.add(user);
		userList.add(user2);
		userList.add(user);

		model.addAttribute("host", "http://blog.didispace.com");
		model.addAttribute("userName", "mutou");
		model.addAttribute(user);
		model.addAttribute(userList);
		model.addAttribute("num", 83);
		model.addAttribute("num1", 3);

		model.addAttribute("bol", true);

		model.addAttribute("path", "/imgs/xyk.jpg");
		//base64图片显示。浏览器不会缓存
		model.addAttribute("imgBase64","data:image/png;base64,/9j/4AAQSkZJRgABAgIAAAAAAAD//gAeQUNEIFN5c3RlbXMgRGlnaXRhbCBJbWFnaW5nAP/AABEIANkAvAMBIgACEQEDEQH/2wCEAAcEBQYFBAcGBQYHBwcIChELCgkJChUPEAwRGRYaGhgWGBgcHygiHB0mHhgYIy8jJikqLS0tGyExNDErNCgsLSsBCwsLDw0PHhERHkArJCtAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQP/EAIsAAAICAwEAAAAAAAAAAAAAAAECAAUDBAYHEAABAwMDAgMGBAUEAgMAAAABAAIRAwQhBTFBElEGYXETIjKBkaEUI0KxUsHR4fAHFTNiU3KCsvEBAQADAQEAAAAAAAAAAAAAAAABAgQDBREBAQACAQQCAwEBAAAAAAAAAAECEQMEEiExQVETIjJCYf/aAAwDAQACEQMRAD8AxgeaJUjaUedoXZ5o7+ak9lNpgRwjETwgE/OVBEyoACd0On6IBhGRCg8kI+iJQnIkqEj7paj2tI48lqV9Tt6M9TiY8k2SVvCCMYQjqVJU8TWbXdIfmc4UqeI7cU5L57KO6LdmS8AgSM+SVxAVGNfpubPV0/JPb6yXjqLOts7tEEfVO6H46uAZiFPmte3vaVxTD6RJB3MZBWdpluCpV0YEox3SkQjmFKBJypJjJlEAFSRB+yBScf3QBwUxEoAbA4wgESUR/mVIGTyggbM/sj6oehhEbZyoBAgSfRGAhOAFIIhBDGECYPlCY5Q42QKI/wD1a99dNt2yCJPms1V7adMvdgNEkrkPEWpGnTc4k9bz7rOwhVyunTjw7qfV9eDZbTqQdyQcLmbrU/xMmpUe6T/Gteox1Rrqt08gcNlabpqGGNJ8lytrZMJGStVJOHEgbIfinuI94wEadpXcMUnH5KVLKtT+Km4BRtbSC6qnHtH+krcs6lZ9Qe9EckrRbTLTlpWWkelwPWf2TZpd2+q17V0zBBy4f5lddouqNv6QMgO5Erh3gVrcAbgfVNpd/Vsqp6cgZIKtjlpzz4pk9LBJOQUZhaml3tO9tW1aT+qcHOxW3/Nd4xWapt8hSTso2PTzUIjiZRAeSH+SiDBUx2QQSpHmoBKCBtuUcqDZTYKASc7KN8kJI3RGUBccbID4Y7KS3hYrirTtqL6tZwa1glxPAQit8R3raFNlv1e/VBdjhoyVw1/emrXqVamWgw2f2WW41ipqV3d13buaW0xEdLZJAWvplm67rgujpZkidyuGeXy9Dh49TRrDTq2oE+0wDwRwur0TwpQYA57GnnIW1omkRUa8jBbtK63T7BzxwBwsfJy34ejxcM91VW+gW2zaDAe8J6/hmzrA+0t2fQhdfa2LabNvVZRZCOoNHzK499+2j8eP083uvB9pJ6aLR8iua13wuygfyh0g+q9jvLIRMLmfEdgWUSXNnj6mFfDlu3PPgx16eTXFjcWP/ISWbAt4WNzmh0uEuHPcLvtS0wVLaHNzC4nULL2BLXTH6StWGcyY+Tj7W94V1h1peNovqQwuDXicHsV6Aw9TQcZ57rx2p7lQOa4z+xXpvhK+F/otu+Ze1vQ4cgj/ACVpwvw8/nx+Yt+P7qTwgTlSMLozIY4BUI+foi4eqXnuUBHxKR5ypAlBAfL+aPrAhCfqjIUJQmP3TR5QSl53UJnkog2RtC5L/UfUhRsG2NN3v1SHP8mj+p/ZdXJAhebeP7g1/ED2n4abQ0CfL+6rlfDrxY7yVOntcHdTckghdl4VsB7APLcuXK6Sz2j2gCcwAF6Lo1BtvZ0+qAQBKyct1Hq8GO7t0Om24bSCvLGnBBC5i21mhSqdNQHojdX+k6/p1esyk1wBMCTssdxrfjnPS/p/8Y6kwgARmVkFAVKQfRLXD/qoy0rE9IY5xOwAVNVfbUuC3I3VNrNFtzSFM4Bc3jsQVf3Fq5kmqAyN+rCpruta9RArsJHAKnVTbNKTU7QezLWj0XC+J9Pm2eY5Xe3N1SeXta8EjzXP6zbivZ1AAPJdeO2Vw5ZMo8rrM9+M5XRf6cXwt9Rq21Vxa2s0R/7A4/cqou7csr+jtoS6a/8AD6zbVRIArMkDHIlb8b5eTyY7lj1nn0Q+SEx6JhwVoeehyd0PJQ4KWMbICR2Qk/4ETPBSnfeEBb5JgCePmhjkwiXZkgZ7KqRaDgAEFQ90AcY3RmNvupBA8l5t4wtvZa5WLpzBknuF6Q3Zcxr2gVtW1eo9jgxga2Scqmd1N136eXLPUctolxStq/tHtJDOAF0thqeoaqem0p0qVAY6n5JWlbeH6uk62aFz0va9nW09xkT9l0vhq0Z/tIaIDy52w/7FY+TKe3qcWGW9UbTShUMXN65veAP6LpfD3g43Ta9e0valSla0zVrOLWHpbBO2Cdlz50OvV9sKgLjUYWtJPw+YV9oTL3SPDT9NZbW/57mve+k2HAtAAl05nM/yVMbL7rtljZ4xiw0fVbizrC3uOnaQ9gwQP23XS6p4oo6VprbqvU6eAemSVyNDxK3QPb21WzbdP1O3faBpdAZ1DLtjIHI5WybzT2WVqzxM6kaWn6dVoWJqU/edWLmFpJ7+6e3KrMcb526W2eNNe/1TUtVaXCgGh3/leB+0rRvvC923S6V7SI9p1O6x1kNJxABjPnstq+e51u0U3PaHO95zBMD0VHd6nqD7WlpLK+pMoM1Co+SfyzSIaGkYmcO5+WVbjm5VOXcs0r7mpUs6nVdW9an07vbDh9s/ZPaapaX1IihWa8ZkbFZqNxV9tUoV3GqwGGvI+IKg/wBja/VLmrSqOpmnBb0juFHi+0XePpTarTFHVXUzsT1D6rVtqIfrFs1v6q7f/sFNQrVKuqP9s2HUz045Vx4Qsxdar7Rw92iOvbnj9lrwjBy2Tdduc4BCmxkShGYRAPK0PMBxJBhAERGMJjjO6XYYhSIds/RDCmfRTCCAjqgppzESsXmPsnBI9SoSYHI2RAASgw7ZMd+FAm4wITaLSFxrF3bCOp9Om4eQkz+yTJBiU3hquLPxvRqVfgq2xb5dQJI/dcuebwrX0OXbzRreJbH2HiJr3GfywBxGThTwyxrTVovw6k8+76kkLP4yLm6rTquBEyPv/dZLaga9IvtaooVXdJc8MB6omAfqsF/l7WEnfXQWwiIGfRb9FtMUyagAA7qqsaOqDPTbVT3Li3+RR1u01KtZv9vcMt6UZp0QS5//AMjBHyXLTvdVT1g3V/F5fRaDa2f5dNw2c7EkfMFWHjiz/F6S6m1vvNEt9QE/hqwbaVGU5a0HZWfiOgZ9myo1xicK1vlWY+FR4Trt1DQrasA01ACyq3fIMZ+xV5Wt7Z9r0mk3qntsue8PWl1a6jXNkG9MTUtz7rSe4MHO2FZ3epV6RIfpd6SP4GhwP3UX34JJry1NQ0+3ZPRTbPeFyzR01Lx4G7w0HvAH910NxdXd2x7W2te2kENfVAEH0VPqdsyysxSYZ7k7k8lWx8e1OXWvCo8L+HaGqtvri5aC5td/TPIj+6vxo1vpFFn4Zgb7UAnGf8yrDwLRY2wqh4AFRxG3cLBqtbrqtZ1YpgCFp4bbyMXVTHHp/wDtapPO6klTMkfspmFueIhzyllSPn81BkqQTG+6BMcT81HSJHCheBiJQIBOxTRslA3z8kcA4ElQsaI/kpERwVCgiDQd5+q0NdqPt7Zl9QMVLaoKgj6H7ErdBB3RkHG8qLNzS2N7buNTWPEemarStKVs97q8wZaQAFaaO1zWtAXM+JKbaVSyrsYGtZUgwIiYXTaJUDmNIjZYObjmHiPa6XmvLd11VrUcykC3nhC8d+JpuY6SCFrtPVTaG7Kv1DVbq0qdDbR3Tw5ZJN16G2xRsCHkuqODhlpnYI1bd4aHsqlz+52C0aGrXhYX/hnuB43WV2rua0OqW7mcx0FW1VtLDSmewe6XdVR+XFWVeoHtkYgKgtdctq9QNILXeh/orNtSXRiDmVWzVRtrX56zErlPETvfA4XW3TmgHy3XH+IKTrqsKNNxYXD4h+ldeKbumbnz7cbavbSl/ttmzrJBa2I4BhVVV/W8uHK1rR+puYG6hei4a1oDYaR8zO5WYyVv4eO4ea8jq+onLrHH1Dgw39kNzIQMRujsIK0MSR9Ch5cI5+iHOAiBIEDOIQAnuikdElElJ7fYoj1Mfuk6pjOAi10zzKhLIDiZ+6jnA5HdY5EoneeEBn7ItMeiWcKM+iDS8QUPxOlVmsEua3qbHcZ/kk8Kan7S2pkkhwHSZPKsYKpLC166tz7Aw5tZ5H1Kz9RJ2tvRZWZajvNOuPaN+LbiVvO6K7S1zQ4eYXKaDqQFwKNeWvGCIXXWLm1D7vK83Kar28MpYxGg2i33GY/hRqWbLlkvbHkFafhKlRoLQANzlMLZ1Me8McKN1134U1tYW1JxikwecZWS5qMpbARCzXZDTlc9rN9TpHLtgkltUtkZr27GYdhUXWK1d1Qwf0grXub191ilhpMdUfssjAGjpYQB2W7puPzt5PXc3jtjO0xARDs7pAZ2IUDsx9VteWcuM4RLp3P3STGQi1wjJlEHnHdRsgSTMeaUYGVCeVJoeJSyPP6p/wBPAQjmQiGAuxgznKk+8kGP6JgYOx8lCx27fupPMylaST2QOPPugfq+qMjYhIIHxDzWte6jb2lMvqvHk2cn5KDW2a+rstbZ9Z7gOkYnk9lj8PW9QUhXqb3P5uNhJXKarrVe+PQB0Up+GQV3HgG5ttasKdmHNZd2zA1oP6+wC488tx8N3Szsy3WW+0gXDRUpyyo3YtS6fqt9p1QNuKTnsH6hnC6GhRGWkZGCDusVe0b7QAtELze74r1tfMJT8XUukBxLfLITP8WUnNj2kgbDK2aGlWlQDro0yd8hZaul2TKeKFIH0TeKf2c7qPiGpWBbb0nPJ52VVTsq95W67kuInbhdE+zo+0hlMfIJ/wAM1jTACmZSelbjv2oLyiKDabWD9QEJOJOJVheWxuK8NnpYCXeQXJ+GNQrXPXQuHF5p5BO639N/Ly+tx/bwvC7JnlFrseaXeS4qNxnBWlhZGuMnvyj1YySsUxxHkm6ueUQy9URzyiD5bLH1iI5RLuknf+iDJO+dlA/yPyKTqkyoTGIRDCDntlGYMlIXe76LUvNTtrQfnVMjgItpvgh0bLV1DUaFmwuquHkAclc/e+Jar3lto0Mb3cM/0VNXrOrVC6o7qcclHTHj+1rqPiC4uQRbu9i3yOSqqrVqVXgvcXHu4ykwRxBwhs3BUO0knoSdsYW3pOo3Gl3zLi0qup1GEGRz5LUaZGZ/uo1pL8nHfyT2tK9h0TxVa+JiPZltrq4BLqL3AMuPQ/xR5ZhWlC5o3RLT+XUbgsdgyvDCSCDIkZVzZ+KNQpvpmrUFYMAHvDOPNZ+Tp8cvTRx89x8V7KxhY0QkuHuc2Oy5TQf9Q9OdbdGoGpRqNxPRIP0yrd3izR6tDro3dN3EQQSsV4c5dabJzY2b226dICSeOEbW2ffGp7JzW0mGC88nsO58lrafVo6m72l5d0qNoXdAax4Dqh7eQzuk8SeMtJsmMsbW6Y1rR7N76bSRTb2b35k59V24+mtv7OPJ1E/yN8KNu2rSpFsUx13FWcRHw/52XkdpqX4PUalxb0/dJPu7YKvPGPi1uoUTp2ktdSsGkyXiH1TyT5eS5Lq92duVtxxmPpizvd7dzp2qUL6n7jocN2uIlbo8l502uaLmua4h4yCOFeaX4lqMIZeDqZwQM/NXZsuP6dS7O0kqA5gggrXs7qnc0G1KJDgdlmzHkUcz4OxG6IJ6s4CQQAjxOYQZA7yRDwRusU9zhMKnSIkj5qUOM1DXbi6HSz8pnMHKrXOqOqS9xiNyZUBa4GEY5Oyq1SSegB6gZQkeSB7t+yh3gAeaLIGAk8eScEAEjfsgHZMBBrJcOEDdQ6VMhmVGsgwCDndEx8JO33QGO2QO6GAY+eEWuzifmhsQXclSDAkGSI4QBMjePIonp3Jj1SxBGd1CQJk5ESN0C50wYTvMb/ZK4DpmUCkAjO/klLomcFN1jq2O8oOaXOyIRBIDnDkcwiAA7H3TNYAInjKAp5I6sDlBltrqravD6Dy09pV/YeJWvLWXbA0fxtkwubcwtOxPoi33RHSc7IrcZfbvre7oXDR7Kqx09iswcO68/pXFai7qpvcCOxVtpniGvS927Bqt74BClyvH9Or49FBB3B+q1rO+oXdLqpOnylbEFS56efuEZiEvlvyE44E8JXNI9T5qGsA0HZFzR3yoGlzTHxFOAQJjIQYhLZ+qaRHOFlpwWkuAhKWjqJzlBGwACExIDZMeSQiHAxgIhwJ7IA4BudimaA9oAHHdLAIOJ8pQZgbII74umdkXwQMQgYAnAKhf5IFMdUzB80Ceo4GUdwIKLYAJP0QLMT1c4TEcjcqOHVxzsg5rY6s45hAGjMxGUzuwCVrI2PyRIAGMEboBEtkTCLidpyO6jmmME78FNEN3ycIFwAS7JS9MCSCniMyMlIMyC6PJBkp1X0nNqUyWuGQVeWniZ1O3a2s0veORyufn3Y6seqjetogQR5lFbjKyQd8wE7iCwHlKCXZKYgdMiQUWAGJEgd0GnuZHMKA9R5hMTB92EEGIAMjdM5pLJGAkmOMpgYEDnhAob7wJKWATjussB0kjbzStAHxBApjIOD6qAAgwDATMgjPKjgWgtBgIMZDTnuhEOyCU5bIwZQDSMzvwgUAdWTlQ8z7pKyFsAd0BAO2eCgVsxMzGFA4RsSAi0ZOwhNTJDpIQYzjIKZpxJEyoRnCgwJHKCPljZAIjsg0h091C9xwTA7FFjOQRPcoB0yYhJUackemVkf1es9kAHTkiEGMCBBGUC587lZIBAIE8FYzE8n5IhmDoEfVM120jCR/xFRuzfmiWYOaDACxukuJA/sslL4wi34T/AOyBAOmSJUmI7IO+J/qoz4QgIa4Nk7FBoBJAmUxUpfEgUkA7/ZTp27qP+NNU3CBWgtbMSo4/L0U/SEx+H5IBM557pXO9307KH4B6I0vhPqgEAweT3UbIIA3UGyj/ANXogmWuJIKMyCBznKH6iidwgV7SGwEWkAb+spn7NSN2+qAPwPVCZcQDOEa27fVK34nIGJHQeSsXS+BB+ycb/NZ6fwBB/9k=");

		model.addAttribute("html", "This is an &lt;em&gt;HTML&lt;/em&gt; text. &lt;b&gt;Enjoy yourself!&lt;/b&gt;");

		return "index";
	}

	/**
	 * 请求某个thymeleaf片段
	 * 
	 * @return
	 */
	@RequestMapping(path = { "/frg", "/fragment" })
	public String fragment(Model model) {
		model.addAttribute("one", "厉害了");
		model.addAttribute("two", "我的歌");
		return "common/footer::footer";
	}

	class User {
		private String name;
		private int age;
		private String sex;
		private boolean flg;
		private Date createTime;

		public Date getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

		public boolean isFlg() {
			return flg;
		}

		public void setFlg(boolean flg) {
			this.flg = flg;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}
	}

}