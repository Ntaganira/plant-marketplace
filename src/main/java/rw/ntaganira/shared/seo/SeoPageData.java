package rw.ntaganira.shared.seo;

import lombok.Builder;
import lombok.Data;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : SeoPageData.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Represents SEO metadata for pages
 * --------------------------------------------------------------------
 */

@Data
@Builder
public class SeoPageData {

    private String title;

    private String description;

    private String keywords;

    private String image;

}