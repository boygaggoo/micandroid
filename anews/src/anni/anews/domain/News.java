package anni.anews.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import anni.core.grid.LongGridBean;

/*
 *import org.compass.annotations.Searchable;
 *import org.compass.annotations.SearchableComponent;
 *import org.compass.annotations.SearchableId;
 *import org.compass.annotations.SearchableProperty;
 */
import org.hibernate.annotations.GenericGenerator;



/**
 * News generated by Lingo.
 *
 * @author Lingo
 * @since 2007年08月16日 下午 23时13分00秒31
 */
@Entity
//@Searchable(alias = "a_news")
@Table(name = "A_NEWS")
public class News extends LongGridBean {
    /** * serial. */
    static final long serialVersionUID = 0L;

    /** * 正常状态. */
    public static final int STATUS_NORMAL = 0;

    /** * 待审. */
    public static final int STATUS_WAIT = 1;

    /** * 被驳回. */
    public static final int STATUS_REJECT = 2;

    /** * 草稿. */
    public static final int STATUS_DRAFT = 3;

    /** * 垃圾. */
    public static final int STATUS_RUBBISH = 4;

    /** * 推荐. */
    public static final int STATUS_RECOMMEND = 5;

    /** * 隐藏. */
    public static final int STATUS_HIDE = 6;

    /** * 不分页. */
    public static final int NO_PAGE = 0;

    /** * 自动分页. */
    public static final int AUTO_PAGE = 1;

    /** * 手工分页. */
    public static final int PAGE_BY_HAND = 2;

    /** * id. */
    //@SearchableId
    private Long id;

    /** * newsCategory. */
    //@SearchableComponent
    private NewsCategory newsCategory;

    /** * name. */
    //@SearchableProperty
    private String name;

    /** * subtitle. */
    //@SearchableProperty
    private String subtitle;

    /** * link. */
    private String link;

    /** * 生成的静态页面地址. */
    private String html;

    /** * 分页方式. */
    private int pageType;

    /** * 自动分页字数. */
    private int pageSize;

    /** * image. */
    private String image;

    /** * hit. */
    private Integer hit;

    /** * summary. */
    //@SearchableProperty
    private String summary;

    /** * content. */
    //@SearchableProperty
    private String content;

    /** * source. */
    //@SearchableProperty
    private String source;

    /** * editor. */
    //@SearchableProperty
    private String editor;

    /** * updateDate. */
    private Date updateDate = null;

    /** * status. */
    private Integer status;

    /** * newsComments. */
    private Set<NewsComment> newsComments = new HashSet<NewsComment>(0);

    /** * newsTags. */
    private Set<NewsTag> newsTags = new HashSet<NewsTag>(0);

    /** * 构造方法. */
    public News() {
    }

    /** * @return id. */
    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    /** * @param id id. */
    public void setId(Long id) {
        this.id = id;
    }

    /** * @return newsCategory. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    public NewsCategory getNewsCategory() {
        return newsCategory;
    }

    /** * @param newsCategory newsCategory. */
    public void setNewsCategory(NewsCategory newsCategory) {
        this.newsCategory = newsCategory;
    }

    /** * @return name. */
    @Column(name = "NAME", length = 100)
    public String getName() {
        return name;
    }

    /** * @param name name. */
    public void setName(String name) {
        this.name = name;
    }

    /** * @return subtitle. */
    @Column(name = "SUBTITLE", length = 100)
    public String getSubtitle() {
        return subtitle;
    }

    /** * @param subtitle subtitle. */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /** * @return link. */
    @Column(name = "LINK", length = 100)
    public String getLink() {
        return link;
    }

    /** * @param link link. */
    public void setLink(String link) {
        this.link = link;
    }

    /** * @return html. */
    @Column(name = "HTML", length = 100)
    public String getHtml() {
        return html;
    }

    /** * @param html html. */
    public void setHtml(String html) {
        this.html = html;
    }

    /** * @return 分页方式. */
    @Column(name = "PAGE_TYPE")
    public int getPageType() {
        return pageType;
    }

    /** * @param pageType int. */
    public void setPageType(int pageType) {
        this.pageType = pageType;
    }

    /** * @return 自动分页字数. */
    @Column(name = "PAGE_SIZE")
    public int getPageSize() {
        return pageSize;
    }

    /** * @param pageSize int. */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /** * @return image. */
    @Column(name = "IMAGE", length = 50)
    public String getImage() {
        return image;
    }

    /** * @param image image. */
    public void setImage(String image) {
        this.image = image;
    }

    /** * @return hit. */
    @Column(name = "HIT")
    public Integer getHit() {
        return hit;
    }

    /** * @param hit hit. */
    public void setHit(Integer hit) {
        this.hit = hit;
    }

    /** * @return summary. */
    @Column(name = "SUMMARY", length = 255)
    public String getSummary() {
        return summary;
    }

    /** * @param summary summary. */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /** * @return content. */
    @Column(name = "CONTENT", length = 60000)
    @Lob
    public String getContent() {
        return content;
    }

    /** * @param content content. */
    public void setContent(String content) {
        this.content = content;
    }

    /** * @return source. */
    @Column(name = "SOURCE", length = 50)
    public String getSource() {
        return source;
    }

    /** * @param source source. */
    public void setSource(String source) {
        this.source = source;
    }

    /** * @return editor. */
    @Column(name = "EDITOR", length = 50)
    public String getEditor() {
        return editor;
    }

    /** * @param editor editor. */
    public void setEditor(String editor) {
        this.editor = editor;
    }

    /** * @return updateDate. */
    @Column(name = "UPDATE_DATE")
    public Date getUpdateDate() {
        if (updateDate != null) {
            return (Date) updateDate.clone();
        } else {
            return null;
        }
    }

    /** * @param updateDate updateDate. */
    public void setUpdateDate(Date updateDate) {
        if (updateDate != null) {
            this.updateDate = (Date) updateDate.clone();
        } else {
            this.updateDate = null;
        }
    }

    /** * @return status. */
    @Column(name = "STATUS")
    public Integer getStatus() {
        return status;
    }

    /** * @param status status. */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /** * @return newsComments. */
    @OneToMany(cascade =  {
        CascadeType.PERSIST, CascadeType.MERGE}
    , fetch = FetchType.LAZY, mappedBy = "news")
    public Set<NewsComment> getNewsComments() {
        return newsComments;
    }

    /** * @param newsComments newsComments. */
    public void setNewsComments(Set<NewsComment> newsComments) {
        this.newsComments = newsComments;
    }

    /** * @return newsTags. */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "A_NEWS_NEWSTAG", joinColumns =  {
        @JoinColumn(name = "NEWS_ID")
    }
    , inverseJoinColumns =  {
        @JoinColumn(name = "NEWSTAG_ID")
    }
    )
    public Set<NewsTag> getNewsTags() {
        return newsTags;
    }

    /** * @param newsTags newsTags. */
    public void setNewsTags(Set<NewsTag> newsTags) {
        this.newsTags = newsTags;
    }
}
