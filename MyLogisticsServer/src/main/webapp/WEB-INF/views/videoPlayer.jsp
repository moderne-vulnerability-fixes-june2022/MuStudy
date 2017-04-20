<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
     <meta charset="utf-8" />
     <title>Accessible HTML5 Video Player</title>
     <meta name="description" content="Custom HTML5 video controls and WebVTT captions." />
     <meta name="author" content="Dennis Lembree, PayPal" />
     <meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- PX-VIDEO CSS -->
<link rel="stylesheet" href="${basePath}resources/css/px-video.css" />

<style>
/*** for demo only ***/
#wrapper {
	width: 640px;
	margin: 1em auto;
	font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
}
#brand a,
p a {
	border: 1px #fff dotted;
}
#brand a:focus,
p a:focus {
	border: 1px #999 dotted;
	outline: none;
}
p {
	padding-top: 1em;
}
</style>

</head>

<body>

<div id="wrapper">

<div id="brand">
	<a href="http://paypal.github.io/"><img src="${basePath}resources/img/web/PayPalOpenSourcecolor.svg" width="224" height="28" alt="PayPal open source"></a>
</div>

<h1><img src="${basePath}resources/img/web/logo-accessible-HTML5-video-player.svg" width="30" height="30" alt=""> Accessible HTML5 Video Player</h1>

<div class="px-video-container" id="myvid">
	<div class="px-video-img-captions-container">
		<div class="px-video-captions hide" aria-hidden="true"></div>
		<video width="640" height="360" poster="${basePath}resources/media/poster_PayPal_Austin2.jpg" controls>
			<!-- video files -->
			<source src="https://www.paypalobjects.com/webstatic/mktg/videos/PayPal_AustinSMB_baseline.mp4" type="video/mp4" />
			<source src="https://www.paypalobjects.com/webstatic/mktg/videos/PayPal_AustinSMB_baseline.webm" type="video/webm" />
			
			<!-- text track file -->
			<track kind="captions" label="English captions" src="${basePath}resources/media/captions_PayPal_Austin_en.vtt" srclang="en" default />
			
			<!-- fallback for browsers that don't support the video element -->
			<div>
				<a href="https://www.paypalobjects.com/webstatic/mktg/videos/PayPal_AustinSMB_baseline.mp4">
					<img src="media/poster_PayPal_Austin2.jpg" width="640" height="360" alt="download video" />
				</a>
			</div>
		</video>
	</div><!-- end container for captions and video -->
	<div class="px-video-controls"></div>
</div><!-- end video container -->

<p><a href="https://github.com/paypal/accessible-html5-video-player">GitHub</a></p>

</div><!-- end page wrapper container -->

<script src="${basePath}resources/js/px-video.js"></script>

<script>

// Initialize
new InitPxVideo({
	"videoId": "myvid",
	"captionsOnDefault": true,
	"seekInterval": 20,
	"videoTitle": "PayPal Austin promo",
	"debug": true
});

</script>

</body>
</html>


