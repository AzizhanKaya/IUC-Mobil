<template>
	<div class="oylama">
		<h1>Oylama ></h1>
		<span class="soru">Soru?</span>
		<ul>
			<li>1.Seçenek</li>
			<li>2.Seçenek</li>
		</ul>
	</div>
</template>

<style>
	.oylama {
		border: 1px solid black;
		box-shadow: 0px 1px 5px 1px rgba(0, 0, 0, 0.2);
		border-radius: 15px;
		overflow: hidden;
		padding: 20px;
		padding-top: 10px;
		margin-inline: auto;
		background: linear-gradient(to bottom, black 30%, white 30%);
		margin: 10px;
	}

	.oylama h1 {
		color: white;
		width: 105%;
	}

	.oylama li {
		list-style-type: none;
		background-color: white;
		width: 80%;
		border: 1px solid black;
		border-radius: 20px;
		margin: 10px;
		line-height: 30px;
		padding-left: 20px;
	}
</style>
