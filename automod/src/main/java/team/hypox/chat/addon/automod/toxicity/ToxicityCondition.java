package team.hypox.chat.addon.automod.toxicity;

import team.hypox.chat.addon.automod.AutoModService;
import team.hypox.chat.core.channel.ChannelData;
import team.hypox.chat.core.structure.channel.ChannelCondition;
import team.hypox.chat.core.structure.channel.decorator.DecoratorChannelCondition;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;

public class ToxicityCondition extends DecoratorChannelCondition {

	public static ToxicityCondition withoutDecorator(AutoModService modService) {
		return new ToxicityCondition(new EndDecorator(), modService);
	}

	private final AutoModService modService;

	public ToxicityCondition(ChannelCondition formatter, AutoModService modService) {
		super(formatter);
		this.modService = modService;
	}

	@Override
	public boolean canListen(ChannelMember recipient, MessageContext ctx, ChannelData channelData) {
		modService.addContext(ctx.message());

		return !modService.isToxic(ctx.message()) && super.canListen(recipient, ctx, channelData);
	}
}
